package br.com.prestadores.prestadoresapi.service.util;

public class Utils {

	public static Double calcularDistancia(Double lat1, Double lon1, Double lat2, Double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return (double) 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			
			// Transformando para Km
			dist = dist * 1.609344;
			return dist;
		}
	}
}
