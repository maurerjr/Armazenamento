package maurercompany.armazenamento;
import java.io.Serializable;

public class Evento implements Serializable {
    private String nomeEvento;
    private String dia;
    private String mes;
    private String ano;



    public Evento(String nomeEvento,int dia, int mes, int ano){
        setNomeEvento(nomeEvento);

        setAno(String.valueOf(ano));
        setDia(String.valueOf(dia));
        setMes(String.valueOf(mes));





    }


    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }




}