<div align="center">

# 🎬 IMDB — Filmoteca

**Gestor de películas, directores y actores en Java, con arquitectura MVC y persistencia binaria**

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white)]()
[![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=flat&logo=apachenetbeanside&logoColor=white)]()
[![MVC](https://img.shields.io/badge/Arquitectura-MVC-0F172A?style=flat)]()
[![Ant](https://img.shields.io/badge/Build-Ant-A81C7D?style=flat&logo=apache&logoColor=white)]()

[Descripción](#-sobre-el-proyecto) · [Funcionalidades](#-funcionalidades) · [Cómo ejecutarlo](#-cómo-ejecutarlo) · [Datos](#-formato-de-los-datos) · [Estructura](#-estructura-del-repositorio) · [Stack](#-stack-tecnológico)

</div>

---

## 📖 Sobre el proyecto

Una **filmoteca por consola** inspirada en IMDB: permite consultar y mantener un catálogo de **películas, directores y actores**, relacionados entre sí. Está construida con el patrón **Modelo-Vista-Controlador** y guarda su estado en ficheros, de modo que los cambios sobreviven entre ejecuciones.

> 📌 **Proyecto académico** (práctica final) de la asignatura de *Programación III* (Universidad de Salamanca).

---

## ✨ Funcionalidades

El menú principal ofrece cinco bloques:

| Opción | Qué permite |
| :--- | :--- |
| **1 · Archivos** | **Exportar** los directores a un fichero de columnas (`.col`) y las películas a una **página HTML** con una tabla. |
| **2 · Películas** | **Alta, baja, modificación y consulta** de películas. |
| **3 · Directores** | Gestión del catálogo de directores. |
| **4 · Actores** | Gestión del catálogo de actores. |
| **5 · Listados** | Listados de películas, directores y actores. |

**Persistencia en dos niveles.** Al arrancar, la aplicación intenta cargar los datos **binarios** (objetos serializados en `binarios/`); si no existen, **carga los ficheros de texto** de `datos/`. Al salir, guarda el estado en formato binario.

---

## 🚀 Cómo ejecutarlo

**Requisitos:** JDK 17.

**Con NetBeans:** abre la carpeta como proyecto y ejecuta (clase principal `practicafinal_unaigarcia.PracticaFinal_UnaiGarcia`).

**Por línea de comandos**, desde la raíz del repositorio (las rutas de `datos/` y `binarios/` son relativas a ella):

```bash
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out practicafinal_unaigarcia.PracticaFinal_UnaiGarcia
```

---

## 🗂️ Formato de los datos

Los ficheros de `datos/` son texto plano con campos separados por `#`. Los elementos de una lista dentro de un campo (reparto, filmografía) se separan con tabulador.

| Fichero | Campos |
| :--- | :--- |
| `peliculas.txt` | título · año · duración · país · dirección · guion · música · reparto · productora · género · sinopsis |
| `actores.txt` | nombre · fecha de nacimiento · nacionalidad · año de debut · películas |
| `directores.txt` | nombre · fecha de nacimiento · nacionalidad · ocupación · películas |

Los datos de ejemplo son un pequeño catálogo de películas conocidas.

---

## 📂 Estructura del repositorio

```
IMDB-Filmoteca/
├── src/
│   ├── model/        Pelicula · Director · Actor · Filmoteca · Model
│   ├── view/         View        # Menús y mensajes por consola
│   ├── controller/   Controller  # Carga, guardado, exportación y listados
│   └── practicafinal_unaigarcia/PracticaFinal_UnaiGarcia.java
├── datos/            # Catálogo inicial en texto
├── binarios/         # Aquí se guarda el estado binario al salir de la aplicación
├── nbproject/ · build.xml · manifest.mf
```

---

## 🖥️ Stack tecnológico

| Categoría | Herramientas |
| :--- | :--- |
| **Lenguaje** | Java 17 |
| **Arquitectura** | MVC · serialización de objetos · ficheros de texto con formato propio |
| **Entorno** | NetBeans · Ant |

---

## 🎓 Qué aprendí

- A **separar modelo, vista y controlador** para que cada parte cambie sin romper las otras.
- A **persistir objetos** con serialización y tener un plan B (cargar desde texto) cuando falla.
- A **exportar** los mismos datos a distintos formatos (HTML y columnas).

---

## 👤 Autoría

**Unai García** — Grado en Ingeniería Informática (Universidad de Salamanca)

- 🐙 GitHub: [@unaigb](https://github.com/unaigb)

---

<div align="center">

**⭐ Si este repositorio te resulta útil, considera darle una estrella.**

</div>
