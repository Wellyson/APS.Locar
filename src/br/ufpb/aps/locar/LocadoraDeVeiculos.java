package br.ufpb.aps.locar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LocadoraDeVeiculos {
	
	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<AdministradorDaLocadora> administradoresDaLocadora = new ArrayList<AdministradorDaLocadora>();
	Map<String , Cliente> veiculosLocados;  
	
	public LocadoraDeVeiculos(){
		veiculosLocados = new HashMap<>();
		
	}
	


	public void locarVeiculo (Veiculo veiculo, Cliente cliente) throws VeiculoException {
		if (veiculosLocados == null)
			throw new NullPointerException("Locadora de ve�culos n�o inicializada!");
		if (veiculosLocados.containsKey(veiculo.getPlaca()))
			throw new VeiculoException("Este ve�culo j� encontra-se locado!");
		veiculosLocados.put(veiculo.getPlaca(), cliente);
	}
	
	
	public List<Veiculo> getVeiculosLocados() throws VeiculoRuntimeException {
		if (veiculosLocados.isEmpty())
			throw new VeiculoRuntimeException("N�o existem ve�culos locados no momento!");
		List<Veiculo> locados;
		locados = new ArrayList<>();
		Veiculo _v;
		Iterator<String> it = veiculosLocados.keySet().iterator();		
		while (it.hasNext()){
			String placa = (String) it.next();
			_v = (Veiculo) getVeiculoPorPlaca(placa);
			locados.add(_v);
		}
		return locados;
	}
	
	
	public List<Cliente> getClientesComVeiculoLocado() throws VeiculoRuntimeException {
		if (veiculosLocados.isEmpty())
			throw new VeiculoRuntimeException("N�o existem ve�culos locados no momento!");		
		List<Cliente> list = new ArrayList<>();
		list.addAll(veiculosLocados.values());
		return list;		
	}
	
	
	public Veiculo getVeiculoPorPlaca(String placa) throws VeiculoRuntimeException {		
		for (Veiculo _v: veiculos) {
			if (_v.getPlaca().equals(placa))
				return _v;
		}
		throw new VeiculoRuntimeException("N�o existe nenhum ve�culo cadastrado com essa a placa: " +
				placa);
	}
	

	public Cliente encerrarLocacao(String placa) throws VeiculoRuntimeException {
		if (!veiculoLocado(placa))
			throw new VeiculoRuntimeException("Ve�culo n�o locado!");
		return veiculosLocados.remove(placa);
	}
	
	
	public boolean veiculoLocado(String placa) throws VeiculoRuntimeException {
		List<Veiculo> locados = getVeiculosLocados();
		for (Veiculo _v: locados)
			if (_v.getPlaca().equals(placa))
				return true;
		throw new VeiculoRuntimeException("O Ve�culo com a placa " + placa + " n�o est� locado!");
	}
	
	
	public List <Veiculo> addVeiculo(Veiculo veiculo) throws JaCadastradoException {
		for (Veiculo v : veiculos) {
			if (veiculo.getPlaca() == v.getPlaca() && veiculo.getNumeracao() == v.getNumeracao()) {
				throw new JaCadastradoException();
			}
		}
		veiculos.add(veiculo);
		return veiculos;
	}


	public List <Cliente> addCliente(Cliente cliente) throws JaCadastradoException {
		for (Cliente c : clientes) {
			if (cliente.getCpf() == c.getCpf()) {
				throw new JaCadastradoException();
			}
		}
		clientes.add(cliente);
		return clientes;
	}
	
	public Cliente removerCliente(String nome, String cpf){
		for(Cliente cliente : clientes){
			if((cliente.getNome()== nome)&&(cliente.getCpf()==cpf)){
				clientes.remove(cliente);
				return cliente;
			}
		}
		throw new NaoCadastradoNoSistemaException("Nao cadastrado no sistema");
		
	}
	

	
	public List<AdministradorDaLocadora> addAdministradoresDaLocadora(AdministradorDaLocadora administradorDaLocadora) {
		for (AdministradorDaLocadora a : administradoresDaLocadora) {
			if (a.getMatricula() == administradorDaLocadora.getMatricula()) {
				throw new JaCadastradoException();
			}
		}
		administradoresDaLocadora.add(administradorDaLocadora);
		return administradoresDaLocadora;
	}
	
	public List<AdministradorDaLocadora> listarAdministradoresDaLocadora() {
		return administradoresDaLocadora;
	}
	
	
	
	public Veiculo removerVeiculo(String numeracao){
		for(Veiculo v: veiculos){
			if(v.getNumeracao()==numeracao){
				veiculos.remove(v);
				return v;
			}
		}
		throw new NaoCadastradoNoSistemaException("nao cadastrado no sistema");
	}
	

	public AdministradorDaLocadora removerAdm(String matricula) {
		for (AdministradorDaLocadora adm : administradoresDaLocadora){
			if(adm.getMatricula() == matricula) {
				administradoresDaLocadora.remove(adm);
				return adm;
			}
		}
		throw new NaoCadastradoNoSistemaException("nao cadastrado no sistema");
	}
	
	public boolean isAdmExiste(String matricula) {
		for (AdministradorDaLocadora a : administradoresDaLocadora){
			if (a.getMatricula() == matricula) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean clienteEstaVazio(){
		boolean vazio = clientes.isEmpty();
		return vazio;
	}
	
	
	public int quantidadeDeCliente(){
		int tamanho;
		tamanho = clientes.size();
		return tamanho;
	}

	public boolean veiculosEstaVazio(){
		boolean vazio = veiculos.isEmpty();
		return vazio;
	}
	
	public int quantidadeDeVeiculos(){
		int tamanho = veiculos.size();
		return tamanho;
	}
	
	public void listarVeiculos(){
		Iterator<Veiculo> it = veiculos.iterator();
		while(it.hasNext()){
			Veiculo v = it.next();
			System.out.println(v.getMarca()+ v.getNumeracao()+ v.getPlaca());
		}
	}
	
	public void listarClientes(){
		Iterator<Cliente> it = clientes.iterator();
		while(it.hasNext()){
			Cliente c = it.next();
			System.out.println(c.getNome()+" "+ c.getCpf());
		}
		
	}


	public List<Cliente> listarCliente () {
		return clientes;
	}
	
	public List<Veiculo> listarVeiculo () {
		return veiculos;
	}
	

	public Cliente removerCliente(Cliente c) {
		for(Cliente clien: clientes){
			if(clien ==  c){
				clientes.remove(c);
				return c;
			}
		}
		
		return null;
	}
	
	public boolean contemVeiculo(Veiculo veiculo, String placa){
		boolean contem = false;
		for(Veiculo veic: veiculos){
			if(veic.getPlaca().equals(placa)){
				return contem = veiculos.contains(veiculo);	
			}
		}
		return false;
	}
	
	

	public boolean isClienteExiste(String cpf) {
		for (Cliente cliente : clientes){
			if (cliente.getCpf() == cpf) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isVeiculoExiste(String numeracao) {
		for (Veiculo v : veiculos){
			if (v.getNumeracao() == numeracao) {
				return true;
			}
		}
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		for (Cliente cliente : clientes){
			if (cliente.getCpf() == cpf) {
				return cliente;
			}
		}
		return null;
	}
	
	public Veiculo buscarVeiculo(String numeracao) {
		for (Veiculo v : veiculos){
			if (v.getNumeracao() == numeracao) {
				return v;
			}
		}
		return null;
	}
	
	
	public void  cadastrarVeiculo(Veiculo veiculo) throws JaCadastradoException {
		for (Veiculo v : veiculos) {
			if (v.getPlaca().equals(veiculo.getPlaca())){
				throw new JaCadastradoException();
			}
		}
		veiculos.add(veiculo);
		
	}

	
	
	
	

}
