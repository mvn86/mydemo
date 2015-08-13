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

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.bouncycastle.util.encoders.Hex;

/**
 * 
 * @CreateTime 2015年4月24日 下午2:03:05
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class ThreeDES {

	private static final String charSet = "UTF-8";

	public static String encrypt(String datasource, String password)
			throws Exception {
		String result = "";
		try {
			byte[] src = datasource.getBytes(charSet);
			result = new String(encrypt(src, password));
		} catch (Exception e) {
			throw new Exception("加密失败");
		}
		return result;
	}

	private static byte[] encrypt(byte[] datasource, String password)
			throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		SecureRandom random = new SecureRandom();
		DESedeKeySpec desKey = new DESedeKeySpec(password.getBytes());

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(desKey);

		Cipher cipher = Cipher.getInstance("DESede");

		cipher.init(1, securekey, random);

		return Hex.encode(cipher.doFinal(datasource));
	}

	public static String decrypt(String input, String password)
			throws Exception {
		byte[] src = (byte[]) null;
		try {
			src = Hex.decode(input);
			src = decrypt(src, password);
		} catch (Exception e) {
			throw new Exception("解密失败");
		}
		return new String(src, charSet);
	}

	private static byte[] decrypt(byte[] src, String password) throws Exception {
		SecureRandom random = new SecureRandom();

		DESedeKeySpec desKey = new DESedeKeySpec(password.getBytes());

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");

		SecretKey securekey = keyFactory.generateSecret(desKey);

		Cipher cipher = Cipher.getInstance("DESede");

		cipher.init(2, securekey, random);

		return cipher.doFinal(src);
	}
}
