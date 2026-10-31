package com.krakedev.asistencias.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.estudiante.Estudiante;

@Service
public class ServicioEstudiantes {
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public Estudiante buscarPorCedula(String cedula) {

		for (Estudiante e : estudiantes) {

			if (e.getCedula().equals(cedula)) {

				return e;
			}
		}
		return null;
	}

	public void agregar(Estudiante estudiante) {

		if (buscarPorCedula(estudiante.getCedula()) == null) {
			estudiantes.add(estudiante);
		}

	}

	public void eliminar(String cedula) {

		Estudiante e = buscarPorCedula(cedula);

		if (e != null) {

			estudiantes.remove(e);
		}

	}

	public void actualizar(String cedula, Estudiante nuevo) {

		Estudiante e = buscarPorCedula(cedula);

		if (e != null) {

			e.setApellido(nuevo.getApellido());
			e.setNombre(nuevo.getNombre());
		}

	}

	public ArrayList<Estudiante> listar() {

		return estudiantes;
	}
}