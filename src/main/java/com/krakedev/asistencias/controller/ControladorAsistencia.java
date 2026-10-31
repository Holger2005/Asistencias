package com.krakedev.asistencias.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.Asistencia;
import com.krakedev.asistencias.services.ServicioAsistencia;

@RestController
@RequestMapping("/asistencia")
public class ControladorAsistencia {

	private final ServicioAsistencia servicioAsistencia;

	public ControladorAsistencia(ServicioAsistencia servicioAsistencia) {
		this.servicioAsistencia = servicioAsistencia;
	}

	@PostMapping("/{cedula}")
	public void crear(@PathVariable("cedula") String cedula) {

		servicioAsistencia.registrarAsistencia(cedula);

	}

	@GetMapping("/{cedula}")
	public List<Asistencia> listar(@PathVariable("cedula") String cedula) {
		return servicioAsistencia.consultarAsistencia(cedula);
	}
}
