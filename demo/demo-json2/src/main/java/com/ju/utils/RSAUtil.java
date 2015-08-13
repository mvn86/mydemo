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
import java.io.FileInputStream;
import java.io.PrintStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

/**
 * 
 * @CreateTime 2015年4月24日 下午1:59:12
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class RSAUtil {
	public static final Provider pro = new BouncyCastleProvider();
	private static final String charSet = "UTF-8";
	private static String publicKeyStr = "";
	private static String privateKeyStr = "";
	private static PrivateKey privateKey = null;
	private static PublicKey publicKey = null;
	private static final String seedKey = "random3";

	public static void generateKeyPair() throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", pro);
		kpg.initialize(1024, new SecureRandom(seedKey.getBytes()));
		KeyPair kp = kpg.generateKeyPair();

		privateKey = kp.getPrivate();
		privateKeyStr = new String(Base64.encode(privateKey.getEncoded()));
		publicKey = kp.getPublic();
		publicKeyStr = new String(Base64.encode(publicKey.getEncoded()));

		System.out.println("PrivateKey:" + privateKey);
		System.out.println("PublicKey:" + publicKey);

		System.out.println("PrivateKeyStr:" + privateKeyStr);
		System.out.println("PublicKeyStr:" + publicKeyStr);
	}

	public static PublicKey getPublicRSAKey(String key) throws Exception {
		X509EncodedKeySpec x509 = new X509EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePublic(x509);
	}

	public static PrivateKey getPrivateRSAKey(String key) throws Exception {
		PKCS8EncodedKeySpec pkgs8 = new PKCS8EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePrivate(pkgs8);
	}

	private static byte[] encrypt(String input) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(1, publicKey);
		byte[] re = cipher.doFinal(input.getBytes(charSet));
		return re;
	}

	private static byte[] decrypt(byte[] encrypted) throws Exception {
		publicKey = getPublicRSAKey(publicKeyStr);
		privateKey = getPrivateRSAKey(privateKeyStr);
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(2, privateKey);
		byte[] re = cipher.doFinal(encrypted);
		return re;
	}

	public static String transfer2MD5(String passwd) throws Exception {
		String jsValue = decodeJsValue(passwd);
		return DigestUtils.md5Hex(jsValue);
	}

	public static String decodeJsValue(String jsValue) throws Exception {
		byte[] input = Hex.decode(jsValue);
		byte[] raw = decrypt(input);

		int i = raw.length - 1;
		while ((i > 0) && (raw[i] != 0)) {
			i--;
		}
		i++;
		byte[] data = new byte[raw.length - i];
		for (int j = i; j < raw.length; j++) {
			data[(j - i)] = raw[j];
		}
		return new String(data, charSet);
	}

	public static String encrypt(String input, String keyFile) throws Exception {
		try {
			FileInputStream in = new FileInputStream(keyFile);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
				X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
						bout.toByteArray());
				KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				publicKey = keyFactory.generatePublic(publicKeySpec);
			}
			in.close();
			Cipher cipher = Cipher.getInstance("RSA", pro);
			cipher.init(1, publicKey);
			byte[] re = cipher.doFinal(input.getBytes(charSet));
			return new String(Hex.encode(re));
		} catch (Exception e) {
			throw new Exception("读取公钥失败", e);
		}
	}

	public static String decrypt(String input, String keyFile) throws Exception {
		byte[] inputByte = Hex.decode(input);
		try {
			FileInputStream in = new FileInputStream(keyFile);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
			}
			in.close();

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
					bout.toByteArray());
			privateKey = keyFactory.generatePrivate(privateKeySpec);
			Cipher cipher = Cipher.getInstance("RSA", pro);
			cipher.init(2, privateKey);
			byte[] re = cipher.doFinal(inputByte);
			return new String(re, charSet);
		} catch (Exception e) {
			throw new Exception("读取私钥失败", e);
		}
	}
}
