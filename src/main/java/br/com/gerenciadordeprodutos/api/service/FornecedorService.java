package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    //primeira assinatura: criação do fornecedor (request/post/dto)
    FornecedorCriadoResponse criarFornecedor(CriarFornecedorRequest criarFornecedorRequest);
    Fornecedor buscarFornecedorPeloId(Long id);
    List<Fornecedor> buscarTodosFornecedores();
    Fornecedor atualizarFornecedor(Long id, CriarFornecedorRequest criarFornecedorRequest);
    void deletarFornecedorPeloId(Long id);

}
