![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Actividad Sumativa Semana 5 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Rodrigo Vásquez
- **Sección:** 002A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad Sumativa de la asignatura *Desarrollo Orientado a Objetos I*. Se trata de un sistema modular desarrollado en Java para la empresa **Salmontt**, enfocado específicamente en el área de **Operaciones y Planta**.

El objetivo es gestionar la nómina de operarios, calcular sus sueldos finales aplicando reglas de negocio (bonos por turno de noche) y validar la información ingresada.

### Características principales:
* **Lectura de Archivos:** Carga masiva de datos desde un archivo `.csv` utilizando librerías nativas de Java (`Scanner`), sin dependencias externas pesadas.
* **Modularidad:** Código organizado en paquetes funcionales (`model`, `services`, `ui`, `util`).
* **POO:** Aplicación estricta de herencia (`Persona` -> `Operario`), composición (`Persona` tiene `Domicilio`) y encapsulamiento.

---

## 🧱 Estructura general del proyecto

```plaintext
SistemaSalmontt_V2/
 ├── .idea/
 ├── src/
 │    └── main/
 │         ├── java/
 │         │    └── cl.salmontt/
 │         │          ├── ui/
 │         │          │     └── Main.java
 │         │          ├── model/
 │         │          │     ├── Domicilio.java
 │         │          │     ├── Operario.java
 │         │          │     └── Persona.java
 │         │          ├── services/
 │         │          │     └── GestorOperaciones.java
 │         │          └── util/
 │         │                └── ValidadorDatos.java
 │         └── resources/
 │                └── nomina_operarios.csv
 ├── target/
 ├── .gitignore
 ├── pom.xml
 └── README.md# SistemaSalmontt_V2