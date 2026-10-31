package com.krakedev.asistencias.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.Asistencia;
import com.krakedev.asistencias.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {

		if (servicioEstudiantes.buscarPorCedula(cedula) != null) {

			Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");

			RegistroAsistencia ra = new RegistroAsistencia(servicioEstudiantes.buscarPorCedula(cedula), asistencia);

			registros.add(ra);

			return ra;
		} else {

			return null;
		}
	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {

		ArrayList<Asistencia> asistenciasEstudiante = new ArrayList<>();

		for (RegistroAsistencia registro : registros) {
			if (registro.getEstudiante() != null && registro.getEstudiante().getCedula().equals(cedula)) {
				asistenciasEstudiante.add(registro.getAsistencia());
			}
		}

		return asistenciasEstudiante;
	}

}
