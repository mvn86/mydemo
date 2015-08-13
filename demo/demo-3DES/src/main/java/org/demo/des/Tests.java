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

package org.demo.des;

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 
 * @CreateTime 2015年4月24日 下午5:10:55
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class Tests {

	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	private static final String MCRYPT_TRIPLEDES = "DESede";
	private static final String TRANSFORMATION = "DESede/CBC/PKCS5Padding";

	public static byte[] decrypt(byte[] data, byte[] key, byte[] iv)
			throws Exception {
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(MCRYPT_TRIPLEDES);
		SecretKey sec = keyFactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		IvParameterSpec IvParameters = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, sec, IvParameters);
		return cipher.doFinal(data);
	}

	public static byte[] encrypt(byte[] data, byte[] key, byte[] iv)
			throws Exception {
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey sec = keyFactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		IvParameterSpec IvParameters = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, sec, IvParameters);
		return cipher.doFinal(data);
	}

	public static byte[] generateSecretKey() throws NoSuchAlgorithmException {
		KeyGenerator keygen = KeyGenerator.getInstance(MCRYPT_TRIPLEDES);
		return keygen.generateKey().getEncoded();
	}

	public static byte[] randomIVBytes() {
		Random ran = new Random();
		byte[] bytes = new byte[8];
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (byte) ran.nextInt(Byte.MAX_VALUE + 1);
		}
		return bytes;
	}

	public static void main(String args[]) throws Exception {
		for (Object obj : java.security.Security.getAlgorithms("Cipher")) {
			System.out.println(obj);
		}

		String plainText = "a12*&1c中文";
		final byte[] secretBytes = Tests.generateSecretKey();

		final byte[] ivbytes = Tests.randomIVBytes();
		System.out.println("plain text: " + plainText);
		byte[] encrypt = Tests.encrypt(plainText.getBytes(), secretBytes,
				ivbytes);
		System.out.println("cipher text: " + encrypt);
		System.out.println("decrypt text: "
				+ new String(Tests.decrypt(encrypt, secretBytes, ivbytes),
						"UTF-8"));
	}

}
