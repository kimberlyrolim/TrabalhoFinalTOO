
from pessoa import Pessoa 

class Cliente(Pessoa):
    """Representa um cliente e gerencia seu histórico de compras."""
    def __init__(self, nome: str, cpf: str, telefone: str, endereco: str, id_cliente: int):
        super().__init__(nome, cpf, telefone, endereco)
        self._id_cliente = id_cliente
        self.historico_compras = [] # A lista começa vazia

    @property
    def id_cliente(self) -> int:
        return self._id_cliente
    
    def adicionar_venda_ao_historico(self, venda):
        self.historico_compras.append(venda)

    def consultar_historico(self):
        print(f"\n--- Histórico de Compras de: {self.nome} ---")
        if not self.historico_compras:
            print("Nenhuma compra registrada.")
            return

        for venda in self.historico_compras:
            print(f"\n  ID da Venda: {venda._id_venda} | Status: {venda._status} | Total: R$ {venda.valor_total:.2f}")
            for produto, quantidade in zip(venda._lista_de_produtos, venda._lista_de_quantidades):
                print(f"    - Item: {produto.nome} ({quantidade}x)")
        
        print("-" * 40)

    def __str__(self):
        return f"Cliente [ID: {self.id_cliente}] - {super().__str__()}"