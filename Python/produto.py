
class Produto:
    def __init__(self, id_produto: int, nome: str, descricao: str, preco: float, qtd_estoque: int = 0, servico: bool = False):
        self._id_produto = id_produto
        self.nome = nome
        self.descricao = descricao
        self.preco = preco
        self._qtd_estoque = qtd_estoque
        self.servico = servico

    @property
    def qtd_estoque(self) -> int:
        return self._qtd_estoque
    
    def verificar_estoque(self, quantidade_desejada: int) -> bool:
        """Verifica se há estoque suficiente. Serviços sempre retornam True."""
        if self.servico:
            return True
        return self._qtd_estoque >= quantidade_desejada

    def remover_do_estoque(self, quantidade_a_remover: int):
        """Remove uma quantidade do estoque. Não faz nada se for um serviço."""
        if not self.servico and self.verificar_estoque(quantidade_a_remover):
            self._qtd_estoque -= quantidade_a_remover
    
    def adicionar_ao_estoque(self, quantidade_a_adicionar: int):
        """Adiciona uma quantidade ao estoque."""
        if not self.servico:
            self._qtd_estoque += quantidade_a_adicionar

    def __str__(self):
        if self.servico:
            return f"Serviço: {self.nome} | Preço: R$ {self.preco:.2f}"
        else:
            return f"Produto: {self.nome} | Estoque: {self._qtd_estoque} | Preço: R$ {self.preco:.2f}"
    
    def __eq__(self, other):
        """Permite a comparação entre dois objetos Produto."""
        if not isinstance(other, Produto):
            return NotImplemented
        return self._id_produto == other._id_produto