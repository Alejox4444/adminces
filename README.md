# ADMINCES

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
