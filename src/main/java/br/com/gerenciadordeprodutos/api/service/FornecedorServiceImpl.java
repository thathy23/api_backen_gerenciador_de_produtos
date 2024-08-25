package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Fornecedor;
import br.com.gerenciadordeprodutos.api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorCriadoResponse criarFornecedor(CriarFornecedorRequest criarFornecedorRequest) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(criarFornecedorRequest.nome());
        fornecedor.setCNPJ(criarFornecedorRequest.cnpj());
        fornecedor.setEmail(criarFornecedorRequest.email());
        fornecedor.setTipoFornecedor(criarFornecedorRequest.tipoFornecedor());
        fornecedor.setCriadoEm(LocalDateTime.now());
        fornecedor.setAtualizadoEm(LocalDateTime.now());

        Fornecedor fornecedorCriado = fornecedorRepository.save(fornecedor);

        return new FornecedorCriadoResponse(
                "Fornecedor criado com sucesso",
                fornecedor.getId()
        );

    }

    @Override
    public Fornecedor buscarFornecedorPeloId(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));

    }

    @Override
    public List<Fornecedor> buscarTodosFornecedores() {
        return fornecedorRepository.findAll();

    }

    @Override
    public Fornecedor atualizarFornecedor(Long id, CriarFornecedorRequest criarFornecedorRequest) {
            Fornecedor fornecedorExistente  = fornecedorRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Fornecedor não encontrado"));

            fornecedorExistente.setNome(criarFornecedorRequest.nome());
            fornecedorExistente.setCNPJ(criarFornecedorRequest.cnpj());
            fornecedorExistente.setEmail(criarFornecedorRequest.email());
            fornecedorExistente.setTipoFornecedor(criarFornecedorRequest.tipoFornecedor());
            fornecedorExistente.setAtualizadoEm(LocalDateTime.now());

            return fornecedorRepository.save(fornecedorExistente);

    }

    @Override
    public void deletarFornecedorPeloId(Long id) {
        Fornecedor fornecedorExistente  = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));
        fornecedorRepository.delete(fornecedorExistente);
        //fornecedorRepository.deleteById(fornecedorExistente.getId());

    }

}