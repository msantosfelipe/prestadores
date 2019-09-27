package br.com.prestadores.prestadoresapi.repository.enums;

import java.security.SecureRandom;

public enum EspecialidadeEnum {

	Cardiologia,
	Dermatologia,
	Oftamologia,
	Odontologia,
	Urologia,
	Otorrinolaringologia;
	
	public static String randomEnum(){
        int x = new SecureRandom().nextInt(EspecialidadeEnum.class.getEnumConstants().length);
        return EspecialidadeEnum.class.getEnumConstants()[x].toString();
    }
}
