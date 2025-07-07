package com.loginbackend.servicio;

import com.loginbackend.modelo.Usuario;
import com.loginbackend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean registrarUsuario(String correo, String usuario, String contrasena) {
        if (usuarioRepositorio.findByCorreo(correo).isPresent() || usuarioRepositorio.findByUsuario(usuario).isPresent()) {
            return false; // Usuario o correo ya existe
        }
        Usuario nuevo = new Usuario();
        nuevo.setCorreo(correo);
        nuevo.setUsuario(usuario);
        nuevo.setContrasena(passwordEncoder.encode(contrasena));
        usuarioRepositorio.save(nuevo);
        return true;
    }

    public boolean autenticarUsuario(String usuario, String contrasena) {
        Optional<Usuario> userOpt = usuarioRepositorio.findByUsuario(usuario);
        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            return passwordEncoder.matches(contrasena, user.getContrasena());
        }
        return false;
    }

    public boolean recuperarContrasena(String correo, String nuevaContrasena) {
        Optional<Usuario> userOpt = usuarioRepositorio.findByCorreo(correo);
        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            user.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepositorio.save(user);
            return true;
        }
        return false;
    }
} 