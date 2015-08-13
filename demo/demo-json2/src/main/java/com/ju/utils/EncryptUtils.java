/*
 * Copyright 2002-2101 SIM group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ju.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

import org.bouncycastle.util.encoders.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @CreateTime 2015年4月24日 下午1:56:14
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class EncryptUtils {

	public static String encrypt(String input, String publicKeyUrl)
			throws Exception {
		String password = RandomUtils.randomString(32);
		String result1 = RSAUtil.encrypt(password, publicKeyUrl);
		String result2 = ThreeDES.encrypt(input, password);
		return result1 + result2;
	}

	public static String decrypt(String input, String privateKeyUrl)
			throws Exception {
		String password = input.substring(0, 128);
		password = RSAUtil.decrypt(password, privateKeyUrl);
		String result = ThreeDES.decrypt(input.substring(128), password);
		return result;
	}

	/*
	 * public static String juEncryptXml(String xml, String publicKeyUrl, String
	 * privateKeyUrl) throws Exception { String result = ""; String reg =
	 * "<msgInfo>"; String reg1 = "</msgInfo>"; String[] xmlStrs =
	 * xml.split(reg); String[] xmlStrs1 = (String[]) null; if (xmlStrs.length
	 * == 2) { xmlStrs1 = xmlStrs[1].split(reg1); if (xmlStrs1.length == 2) {
	 * String password = RandomUtils.randomString(16); String result1 =
	 * RSAUtil.encrypt(password, publicKeyUrl); String result2 =
	 * DES.encrypt(xmlStrs1[0], password); result = reg + result1 + result2 +
	 * reg1; xml = xml.replaceAll("<msgInfo>.*</msgInfo>", result); File pbFile
	 * = new File(publicKeyUrl); File prFile = new File(privateKeyUrl); result =
	 * SignatureXML.SignatureXMLDocument4XmlStr(xml, prFile, pbFile); result =
	 * result.replace("+", "%2B").replace("&", "%26"); } else { throw new
	 * Exception("xml有误，<msgInfo>标签缺少"); } } else { throw new
	 * Exception("xml有误，<msgInfo>标签缺少"); } return result; }
	 */

	public static String juSignature(String msg, String publicKeyFileUrl)
			throws Exception {
		String signature = "";
		PublicKey publicKey = null;

		FileInputStream in = new FileInputStream(publicKeyFileUrl);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout = new ByteArrayOutputStream();
		byte[] tmpbuf = new byte[1024];
		int count = 0;
		while ((count = in.read(tmpbuf)) != -1) {
			bout.write(tmpbuf, 0, count);
			tmpbuf = new byte[1024];
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
					bout.toByteArray());
			publicKey = keyFactory.generatePublic(publicKeySpec);
		}
		in.close();
		String publicKeyStr = new String(Base64.encode(publicKey.getEncoded()));
		MD5 md5 = new MD5();
		signature = md5.calcMD5(publicKeyStr + msg);
		return signature;
	}

	@SuppressWarnings("unchecked")
	public static Boolean juValidateSignature(String msg,
			String publicKeyFileUrl) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(msg, Map.class);
		String signature = (String) map.get("signature");
		map.put("signature", "@eidpay");
		msg = mapper.writeValueAsString(map);
		String signatureStr = juSignature(msg, publicKeyFileUrl);
		if (signature.equals(signatureStr)) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}
}
