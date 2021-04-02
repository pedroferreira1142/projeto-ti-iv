package models;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryption 
{
	
	/**
	 * Verificação da password introduzida com a password encriptada
	 * 
	 *  @throws NoSuchAlgorithmException
	 *  @throws InvalidKeySpecException
	 *  
	 *  @return Boolean
	 **/
	public boolean autenticacao(String passwordIntroduzida, byte[] passwordEncriptada, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException 
	{		
		// Encriptação da password introduzida utilizando o mesmo "salt" que
		// foi utilizado para criar a password original
		byte[] passwordIntroduzidaEncriptada = getPasswordEncriptada(passwordIntroduzida, salt);

		// Authentication succeeds if encrypted password that the user entered
		// is equal to the stored hash
		return Arrays.equals(passwordEncriptada, passwordIntroduzidaEncriptada);
	}

	
	/**
	 *  Recebe a password em clear-text e retorna a password encriptada
	 * 
	 *  @throws NoSuchAlgorithmException
	 *  @throws InvalidKeySpecException
	 *  
	 *  @return EncriptedPassword byte[]
	 **/
	public byte[] getPasswordEncriptada(String password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException 
	{
		// PBKDF2 com um algoritmo de SHA-1
		String algoritmo = "PBKDF2WithHmacSHA1";
		
		int cumpChaveDerivada = 160;
		int iteracoes = 20000;

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iteracoes, cumpChaveDerivada);

		SecretKeyFactory f = SecretKeyFactory.getInstance(algoritmo);

		return f.generateSecret(spec).getEncoded();
	}
	

	
	/**
	 *  Gera um Salt
	 * 
	 *  @throws NoSuchAlgorithmException
	 *  
	 *  @return Salt byte[]
	 **/
	public byte[] gerarSalt() throws NoSuchAlgorithmException 
	{
		// É importante usar um SecureRandom em vez de um Random
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

		// Gera um salt de 8 bytes
		byte[] salt = new byte[8];
		random.nextBytes(salt);

		return salt;
	}
}
