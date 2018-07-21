package testeJsp.modelo;

public class Casa {
	double valor;
	String nome;
	double descontado;
	
	public void descontoCasa() {
		this.descontado= this.valor-(this.valor*0.30);
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getDescontado() {
		return descontado;
	}
	public void setDescontado(double descontado) {
		this.descontado = descontado;
	}
	
}
