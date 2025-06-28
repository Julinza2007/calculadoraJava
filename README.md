# Versión de JAVA 21

# Integrantes del grupo

* **Giménez Ignacio**
* **Lafflito Sebastián**
* **Laje Eluney**
* **Linzalata Julián**

## Recomendaciones a la hora de crear un JPanel con varios botones, o sea un `Container de botones.`

### Es importante usar un buen `Layout` para nuestro container de botones.
#### ¿Qué es un Layout?
- Nos sirve para manejar `DE QUÉ FORMA` se van a mostrar los componentes de nuestro Container.
- Facilita básicamente la tarea de colocarlos de manera ordenada, o de forma "Normalizada".

#### Ok pero qué Layout utilizo? HAY MUCHOS.
- Es verdad, hay muchos.
- En mi opinión, va a depender de qué quieras hacer con tu container.
- Creo `QUE EN NUESTRO CASO` vamos a usar el `BoxLayout`.

#### ¿Cómo se usa?
1. Primero create un container de tipo JPanel, como lo venimos haciendo. `SIEMPRE DESDE EL APARTADO DESIGN`

2. Después pone los botones adentro del container.

3. Y luego vas a la parte de `Layouts` y seleccionás el `BoxLayout`. Está abajo de CardLayout.

4. No es un objeto físico en sí, es una propiedad o atributo o característica o como quieras decirle y le das `Click` en el `Container Recién Creado` y se va a aplicar.

6. Por default va a estar puesta la orientación de forma horizontal (Para darte cuenta de esto tenes que tener un tamaño considerable del contenedor, y al menos tener dos componentes, o botones en nuestro caso.), para ponerlo en vertical vas a tener que ir al Source o sea el código en sí mismo y cambiar esto:

```java
panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
```
por esto:

```java
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
```

Básicamente cambias el sentido de horizontal (por default) a vertical.

## Si trabajan desde GitBash estos son los comandos para trabajar comodamente:

<strong>`LO PRIMERO QUE DEBEN HACER` cuando llegan al laboratorio</strong>
```bash
git clone https://github.com/Julinza2007/calculadoraJava.git
```

### Comandos básicos:
Para guardar cambios:
```bash
git add .
```
```bash
git commit -m "mensaje"
```

Cambiar de rama:
```bash
git checkout el_nombre_de_tu_rama
```

## Para trabajar en tu rama (O sea tu parte) tenes que hacer estos pasos:

1) Traer tu rama.
```bash
git pull origin el_nombre_de_tu_rama
```

2) Para ya poder escribir tu parte del código primero hacen esto:
```bash
git checkout el_nombre_de_tu_rama
```

3) Y lo más divertido, abrir el Eclipse y ya codear tu parte.
   
`(Inserte imagen de abrir Eclipse)`
`(Inserte imagen de codear tu parte)`

4) Una vez terminado, hacer estos comandos:

```bash
git add .
```
```bash
git commit -m "mensaje"
```
```bash
git push origin el_nombre_de_tu_rama
```

---
# `y recuerden:`
<img src="https://i.redd.it/xegl81xwl8w81.jpg" width="330px" height="300px">


<img src="parrot.gif" width="300" height="250" />
