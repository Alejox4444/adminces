# ADMINCES

## Cómo ejecutar el proyecto

1. Abrí IntelliJ → **File > Open** → seleccioná la carpeta `principal`
2. Cuando aparezca el cartel **"Load Maven Project"**, hacé clic en él
3. Navegá hasta `Main.java` y hacé clic en el triángulo verde ▶ junto al método `main`
4. La consola va a mostrar el menú. Ingresá el número de la opción que quieras y presioná Enter.

# UML Entrega Final

<img width="1426" height="636" alt="imagen" src="https://github.com/user-attachments/assets/d8cd3695-7eb5-4d7e-a4b8-7845e8174085" />


# Listado de Funcionalidades

## 1. Iniciar sesión (Administrador)

### Descripción
Permite que un usuario administrador acceda al sistema utilizando sus credenciales.

### Datos requeridos
- Email
- Contraseña

## 2. Reiniciar contraseña

### Descripción
Permite actualizar la contraseña de una cuenta existente.

### Datos requeridos
- Email
- Contraseña nueva

### 3. Registro de Administrador

### Descripción
Permite crear una nueva cuenta con perfil de administrador.

### Datos requeridos
- Nombre
- Apellido
- Email
- País de nacimiento
- Contraseña

---

# Funcionalidades disponibles para Administrador autenticado

## 4. Crear usuarios

### Descripción
Permite al administrador registrar nuevos usuarios dentro del sistema.

### Datos requeridos
- Nombre
- Apellido
- Email
- País de nacimiento
- Contraseña
- Tipo de perfil

---

## 5. Ver usuarios

### Descripción
Muestra la lista de usuarios registrados en el sistema y permite eliminar usuarios con perfil Tester

### Datos visualizados
- Nombre
- Apellido
- Email
- País
- Tipo de perfil

---

## 6. Ver perfil

### Descripción
Permite visualizar y editar la información del usuario autenticado.

### Datos editables
- Nombre
- Apellido
- Email
- País (seleccionado desde un combo)

### Datos visualizados
- Tipo de perfil

---

## 7. Cerrar sesión

### Descripción
Finaliza la sesión del usuario autenticado y retorna al login.
