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

package org.demo.show.providers.test;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESTest {

	public static void main(String[] args) throws Exception {
		

		String text = "kyle boon";

		byte[] codedtext = new TripleDESTest().encrypt(text);
		String decodedtext = new TripleDESTest().decrypt(codedtext);

		System.out.println(codedtext); // this is a byte array, you'll just see
										// a reference to an array
		System.out.println(decodedtext); // This correctly shows "kyle boon"
	}

	public byte[] encrypt(String message) throws Exception {
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
				.getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		final byte[] plainTextBytes = message.getBytes("utf-8");
		final byte[] cipherText = cipher.doFinal(plainTextBytes);
		// final String encodedCipherText = new sun.misc.BASE64Encoder()
		// .encode(cipherText);

		return cipherText;
	}

	public String decrypt(byte[] message) throws Exception {
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
				.getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		// final byte[] encData = new
		// sun.misc.BASE64Decoder().decodeBuffer(message);
		final byte[] plainText = decipher.doFinal(message);

		return new String(plainText, "UTF-8");
	}
}