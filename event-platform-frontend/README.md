### 1. **Instalar Angular CLI**

Primero, asegúrate de tener Node.js y npm instalados en tu máquina. Luego, puedes instalar Angular CLI (Command Line Interface) globalmente usando el siguiente comando:

```bash
npm install -g @angular/cli
```

### 2. **Crear un nuevo proyecto Angular**

Una vez que Angular CLI esté instalado, puedes crear un nuevo proyecto ejecutando:

```bash
ng new nombre-del-proyecto
```

Sigue las instrucciones en la terminal para configurar tu proyecto. Puedes elegir opciones como el uso de routing y el estilo (CSS, SCSS, etc.).

### 3. **Navegar al directorio del proyecto**

Después de crear el proyecto, navega al directorio del mismo:

```bash
cd nombre-del-proyecto
```

### 4. **Iniciar el servidor de desarrollo**

Para ver tu aplicación en acción, inicia el servidor de desarrollo con el siguiente comando:

```bash
ng serve
```

Luego, abre tu navegador y ve a `http://localhost:4200`. Deberías ver la página de inicio de Angular.

### 5. **Estructura del proyecto**

La estructura básica de un proyecto Angular incluye:

- **src/app**: Aquí es donde se encuentran los componentes, servicios y módulos de tu aplicación.
- **src/assets**: Para archivos estáticos como imágenes y estilos.
- **src/environments**: Para configuraciones específicas de entorno (desarrollo, producción).

### 6. **Crear un componente**

Para crear un nuevo componente, usa el siguiente comando:

```bash
ng generate component nombre-del-componente
```

Esto creará un nuevo directorio con los archivos del componente en `src/app/nombre-del-componente`.

### 7. **Agregar lógica y estilos**

Abre el archivo `nombre-del-componente.component.ts` para agregar la lógica de tu componente y `nombre-del-componente.component.html` para el HTML. Puedes agregar estilos en `nombre-del-componente.component.css`.

### 8. **Usar el componente en la aplicación**

Para usar tu nuevo componente, asegúrate de que esté declarado en el módulo correspondiente (normalmente `app.module.ts`). Luego, puedes incluirlo en el HTML de otro componente, como `app.component.html`, usando su selector.

### 9. **Servicios y HTTP**

Si necesitas hacer llamadas a una API, puedes crear un servicio:

```bash
ng generate service nombre-del-servicio
```

Luego, puedes usar `HttpClient` para realizar solicitudes HTTP. Asegúrate de importar `HttpClientModule` en tu `app.module.ts`.

### 10. **Construir para producción**

Cuando estés listo para desplegar tu aplicación, puedes construirla para producción con:

```bash
ng build --prod
```

Esto generará una carpeta `dist` con los archivos optimizados para producción.

### Recursos adicionales

- [Documentación oficial de Angular](https://angular.io/docs)
- [Tutoriales y guías](https://angular.io/tutorial)

¡Espero que esta guía te ayude a comenzar con tu proyecto en Angular! Si tienes alguna pregunta específica o necesitas más detalles sobre algún paso, no dudes en preguntar.