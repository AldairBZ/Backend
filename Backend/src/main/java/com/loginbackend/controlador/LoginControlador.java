package com.loginbackend.controlador;

import com.loginbackend.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String usuario = body.get("usuario");
        String contrasena = body.get("contrasena");
        if (correo == null || usuario == null || contrasena == null) {
            return ResponseEntity.badRequest().body("Faltan datos obligatorios");
        }
        boolean exito = usuarioServicio.registrarUsuario(correo, usuario, contrasena);
        if (exito) {
            return ResponseEntity.ok("Usuario registrado con éxito");
        } else {
            return ResponseEntity.badRequest().body("El usuario o correo ya existe");
        }
    }

    @PostMapping("/ingresar")
    public ResponseEntity<?> ingresar(@RequestBody Map<String, String> body) {
        String usuario = body.get("usuario");
        String contrasena = body.get("contrasena");
        if (usuario == null || contrasena == null) {
            return ResponseEntity.badRequest().body("Faltan datos obligatorios");
        }
        boolean exito = usuarioServicio.autenticarUsuario(usuario, contrasena);
        if (exito) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }

    @PostMapping("/recuperar")
    public ResponseEntity<?> recuperar(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String nuevaContrasena = body.get("nuevaContrasena");
        if (correo == null || nuevaContrasena == null) {
            return ResponseEntity.badRequest().body("Faltan datos obligatorios");
        }
        boolean exito = usuarioServicio.recuperarContrasena(correo, nuevaContrasena);
        if (exito) {
            return ResponseEntity.ok("Contraseña actualizada");
        } else {
            return ResponseEntity.badRequest().body("Correo no encontrado");
        }
    }

    @GetMapping("/google")
    public ResponseEntity<?> loginGoogle() {
        return ResponseEntity.ok("Estructura para login con Google (OAuth pendiente)");
    }

    @GetMapping("/facebook")
    public ResponseEntity<?> loginFacebook() {
        return ResponseEntity.ok("Estructura para login con Facebook (OAuth pendiente)");
    }

    @GetMapping("/instagram")
    public ResponseEntity<?> loginInstagram() {
        return ResponseEntity.ok("Estructura para login con Instagram (OAuth pendiente)");
    }
} 