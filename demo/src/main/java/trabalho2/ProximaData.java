package trabalho2;

import java.util.Scanner;

public class ProximaData {
    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Digite a data no formato: dd/mm/aaaa: ");
            String data = in.nextLine();
            checkerLength(data);
        }
    }

    public String checkerLength(String data) {
        int tamanho = 10;
        if (data.length() == tamanho) {
           return checkerDigit(data);
        } else {
            System.out.println("ERRO: tamanho invalido.");
            return "ERRO: tamanho invalido.";
        }
    }


    public String checkerDigit(String data) {
     
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (i == 2 || i == 5) {
                if (c != '/') {
                    System.out.println("ERRO: nao utilizou '/'.");
                    return "ERRO: nao utilizou '/'.";
                }
            } else {
                if (!Character.isDigit(c)) {
                    System.out.println("ERRO: nao utilizou digito.");
                    return "ERRO: nao utilizou digito.";
                }
            }

        }
        return checkerValidYear(data);
    }

    public String checkerValidYear(String data) {
    
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (i == 6) {
                char c2 = data.charAt(i + 1);
                char c3 = data.charAt(i + 2);
                char c4 = data.charAt(i + 3);

                String ctoString = Character.toString(c);
                String c2toString = Character.toString(c2);
                String c3toString = Character.toString(c3);
                String c4toString = Character.toString(c4);

                String anoString = ctoString + c2toString + c3toString + c4toString;
                int ano = Integer.parseInt(anoString);

                if (ano < 1600 || ano > 9998) {
                    System.out.println("ERRO: data invalida.");
                    return "ERRO: data invalida.";
                    
                }

                return checkerValidMonth(data, ano);
            }
        }
        return null;
    }

    public String checkerValidMonth(String data, int ano) {
    
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (i == 3) {
                char c2 = data.charAt(i + 1);
                String ctoString = Character.toString(c);
                String c2toString = Character.toString(c2);
                String mesString = ctoString + c2toString;

                int mes = Integer.parseInt(mesString);

                if (mes <= 0 || mes > 12) {
                    System.out.println("ERRO: data invalida.");
                    return "ERRO: data invalida.";
                    
                }

                return checkerValidDay(data, mes, ano);

            }
        }
        return null;
    }

    public String checkerValidDay(String data, int mes, int ano) {
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (i == 0) {
                char c2 = data.charAt(i + 1);
                String ctoString = Character.toString(c);
                String c2toString = Character.toString(c2);
                String diaString = ctoString + c2toString;
                int dia = Integer.parseInt(diaString);
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (dia <= 0 || dia > 31) {
                        System.out.println("ERRO: data invalida.");
                        return "ERRO: data invalida.";
                    }
                }

                else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia <= 0 || dia > 30) {
                        System.out.println("ERRO: data invalida.");
                        return "ERRO: data invalida.";
                    }
                }

                else if (mes == 2) {
                    if (((ano % 4 == 0) && (ano % 100 != 0))) {
                        if (dia <= 0 || dia > 29) {
                            System.out.println("ERRO: data invalida.");
                            return "ERRO: data invalida.";
                        }
                    } else {
                        if (dia <= 0 || dia > 28) {
                            System.out.println("ERRO: data invalida.");
                            return "ERRO: data invalida.";
                        }
                    }
                }

               return proximoDia(dia, mes, ano);

            }
        }
        return null;
    }

    public String proximoDia(int dia, int mes, int ano) {
        int proximoDia = 0;
        int proximoMes = 0;
        int proximoAno = 0;

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) { // TEM 31 DIAS
            if (dia < 31) {
                proximoDia = dia + 1;
                proximoMes = mes;
                proximoAno = ano;
            } else if (dia == 31) {
                proximoDia = 1;
                proximoMes = mes;

                if (proximoMes < 12) {
                    proximoMes = mes + 1;
                    proximoAno = ano;
                }

                else if (mes == 12) {
                    proximoMes = 1;
                    proximoAno = ano + 1;
                }
            }

        }

        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // TEM 30 DIAS

            if (dia < 30) {
                proximoDia = dia + 1;
                proximoMes = mes;
                proximoAno = ano;
            } else if (dia == 30) {
                proximoDia = 1;
                proximoMes = mes + 1;
                proximoAno = ano;

            }
            
        }

        else if (mes == 2) {
            if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))) { // É BISSEXTO - 29 DIAS
                if (dia < 29) {
                    proximoDia = dia + 1;
                    proximoMes = mes;
                    proximoAno = ano;
                } else if (dia == 29) {
                    proximoDia = 1;
                    proximoMes = mes + 1;
                    proximoAno = ano;
                  
                }
               
            } else { // NÃO É BISSEXTO - 28 DIAS
                if (dia < 28){
                    proximoDia = dia + 1;
                    proximoMes = mes;
                    proximoAno = ano;
                  }
                  else if (dia == 28){
                    proximoDia = 1;
                    proximoMes = mes + 1;
                    proximoAno = ano;
                  }
                  
            }
        }

        if (proximoMes < 10 ) {
            if(proximoDia<10){
                System.out.println("0" + proximoDia + "/0" + proximoMes + "/" + proximoAno);
                return "0" + proximoDia + "/0" + proximoMes + "/" + proximoAno;
            }
            else{
                System.out.println(proximoDia + "/0" + proximoMes + "/" + proximoAno);
                return proximoDia + "/0" + proximoMes + "/" + proximoAno;
            }
            
        } else {
            if(proximoDia<10){
                System.out.println("0" + proximoDia + "/" + proximoMes + "/" + proximoAno);
                return "0" + proximoDia + "/" + proximoMes + "/" + proximoAno;
            }
            else{
                System.out.println(proximoDia + "/" + proximoMes + "/" + proximoAno);
                return proximoDia + "/" + proximoMes + "/" + proximoAno;
            }
        }

    }
}