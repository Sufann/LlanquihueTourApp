# LlanquihueTourApp

## Descripcion
Proyecto de consola en Java para la agencia Llanquihue Tour (Region de Los Lagos). Carga los datos de personas vinculadas a la agencia desde un archivo de texto (`resources/personas.txt`) dentro de un `ArrayList`, validando el formato del RUT y permitiendo listar, buscar y filtrar los registros por consola.

## Paquetes y clases
- `model`: `Persona`, `Rut`, `Direccion`, `Empleado`, `GuiaTuristico`, `Cliente`
- `service`: `GestorPersonas` (lectura del archivo, carga en `ArrayList`, filtros y busquedas)
- `util`: `RutInvalidoException` (excepcion para validar el formato del RUT)
- `app`: `Main` (menu principal y ejecucion del programa)
- `resources`: `personas.txt` (datos de prueba separados por `;`)

## Como ejecutar
1. Abrir el proyecto en IntelliJ IDEA o NetBeans (JDK 17 o superior).
2. Asegurarse de que la carpeta `src` este configurada como carpeta de fuentes.
3. Abrir la clase `app.Main` (`src/app/Main.java`) y ejecutar el metodo `main`.
4. Usar las opciones del menu en consola para listar, filtrar o buscar registros.
