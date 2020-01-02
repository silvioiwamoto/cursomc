package com.silvioiwamoto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.silvioiwamoto.cursomc.domain.Categoria;
import com.silvioiwamoto.cursomc.domain.Cidade;
import com.silvioiwamoto.cursomc.domain.Cliente;
import com.silvioiwamoto.cursomc.domain.Endereco;
import com.silvioiwamoto.cursomc.domain.Estado;
import com.silvioiwamoto.cursomc.domain.Produto;
import com.silvioiwamoto.cursomc.domain.enums.TipoCliente;
import com.silvioiwamoto.cursomc.repositories.CategoriaRepository;
import com.silvioiwamoto.cursomc.repositories.CidadeRepository;
import com.silvioiwamoto.cursomc.repositories.ClienteRepository;
import com.silvioiwamoto.cursomc.repositories.EnderecoRepository;
import com.silvioiwamoto.cursomc.repositories.EstadoRepository;
import com.silvioiwamoto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRpository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador",2000.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerias");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678912", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("993456035","9982750911"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 303", "Jardim", "74308110", cli1, c1);
		Endereco e2 = new Endereco(null, "avenida Matos", "105", "sala 800", "Centro", "74275080", cli1	, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRpository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
