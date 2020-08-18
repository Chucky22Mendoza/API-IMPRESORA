# API IMPRESORA

### Estructura actualizada 17/08/2020

## Requisitos

* Marca MASUNG
* Modelo MS-D245
* Papel termino 58 mm
* Librería jssc-2.8.0
* Java 8

#### BUILD JAR CON LIBRERÍAS EMBEBIDAS

```xml
    <target name="-post-jar">
        <property name="store.jar.name" value="API IMPRESORA"/>
 
        <property name="store.dir" value="dist"/>
        <property name="store.jar" value="${store.dir}/${store.jar.name}.jar"/>
 
        <echo message="Packaging ${application.title} into a single JAR at ${store.jar}"/>
 
        <jar destfile="${store.dir}/temp_final.jar" filesetmanifest="skip">
            <zipgroupfileset dir="dist" includes="*.jar"/>
            <zipgroupfileset dir="dist/lib" includes="*.jar"/>
 
            <manifest>
                <attribute name="Main-Class" value="${main.class}"/>
            </manifest>
        </jar>
 
        <zip destfile="${store.jar}">
            <zipfileset src="${store.dir}/temp_final.jar"
                        excludes="META-INF/*.SF, META-INF/*.DSA, META-INF/*.RSA"/>
        </zip>
 
        <delete file="${store.dir}/temp_final.jar"/>
        <delete dir="${store.dir}/lib"/>
        <delete file="${store.dir}/README.TXT"/>
    </target>
```