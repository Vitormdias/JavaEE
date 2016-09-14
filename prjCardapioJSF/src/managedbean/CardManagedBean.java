package managedbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CardManagedBean {
	private String prato , conv;
	private String[] acomp;
	private double preco;
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getprato() {
		return prato;
	}
	public void setprato(String prato) {
		this.prato = prato;
	}
	public String getConv() {
		return conv;
	}
	public void setConv(String conv) {
		this.conv = conv;
	}
	public String[] getacomp() {
		return acomp;
	}
	public void setacomp(String[] acomp) {
		this.acomp = acomp;
	}
	
	public void calcula() {
		if(prato.equals("massa"))
			preco = 12;
		else if(prato.equals("carne") || prato.equals("peixe"))
			preco = 10;
		
		if(conv.equals("placomp"))
			preco -= 0.1 * preco;
		else if(conv.equals("abutua"))
			preco -= 0.15 * preco;
		else if(conv.equals("google"))
			preco -= 0.2 * preco;
		else if(conv.equals("prefeitura"))
				preco -= 0.25 * preco;
		
		for(String s : acomp)
		{
			if("salada".equals(s)) {
				preco += 2;
			}
			else if("legumes".equals(s)) {
				preco += 2;
			}
			else if("farofa".equals(s)) {
				preco += 3;
			}
			else if("fritas".equals(s)) {
				preco += 4;
			}
		}
	}
}