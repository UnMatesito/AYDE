package Practica1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Estudiante vec1[] = new Estudiante[2];
        Profesor vec2[] = new Profesor[3];
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            vec1[i] = new Estudiante();
            System.out.println("Ingrese el nombre del estudiante");
            vec1[i].setNombre(s.nextLine());
            System.out.println("Ingrese el apellido del estudiante");
            vec1[i].setApellido(s.nextLine());
            System.out.println("Ingrese la comision a la que pertenece");
            vec1[i].setComision(s.nextLine());
            System.out.println("Ingrese el e-mail del estudiante");
            vec1[i].setEmail(s.nextLine());
            System.out.println("Ingrese la cuidad donde reside el estudiante");
            vec1[i].setDireccion(s.nextLine());
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(vec1[i].tusDatos());
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            vec2[i] = new Profesor();
            System.out.println("Ingrese el nombre del profesor");
            vec2[i].setNombre(s.nextLine());
            System.out.println("Ingrese el apellido del profesor");
            vec2[i].setApellido(s.nextLine());
            System.out.println("Ingrese el Email del profesor");
            vec2[i].setEmail(s.nextLine());
            System.out.println("Ingrese la catedra a la que pertenece del profesor");
            vec2[i].setCatedra(s.nextLine());
            System.out.println("Ingrese al facultad donde da clases");
            vec2[i].setFacultad(s.nextLine());
            System.out.println();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(vec2[i].tusDatos());
        }

    }
}
