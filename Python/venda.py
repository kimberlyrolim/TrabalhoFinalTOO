
from datetime import datetime
from cliente import Cliente
from funcionario import Funcionario
from produto import Produto

class Venda:
    """Gerencia uma transação de venda."""
    def __init__(self, id_venda: int, cliente: Cliente, funcionario: Funcionario):
        self._id_venda = id_venda
        self._data_hora = datetime.now()
        self._cliente = cliente
        self._funcionario = funcionario
        self._status = "Em Aberto"
        self._valor_total = 0.0
        self._lista_de_produtos = []
        self._lista_de_quantidades = []

        if cliente:
            cliente.adicionar_venda_ao_historico(self)

        if funcionario:
            funcionario.adicionar_venda_ao_historico(self)
            
    @property
    def valor_total(self) -> float:
        self._calcular_valor_total()
        return self._valor_total
    
    def _encontrar_indice_produto(self, produto_a_buscar: Produto) -> int:
        try:
            return self._lista_de_produtos.index(produto_a_buscar)
        except ValueError:
            return -1

    def adicionar_item(self, produto: Produto, quantidade: int):
        if quantidade <= 0:
            print("Erro: A quantidade deve ser positiva.")
            return

        if not produto.verificar_estoque(quantidade):
            print(f"Erro: Estoque insuficiente para '{produto.nome}'.")
            return
        
        produto.remover_do_estoque(quantidade)

        indice = self._encontrar_indice_produto(produto)

        if indice != -1:
            self._lista_de_quantidades[indice] += quantidade
        else:
            self._lista_de_produtos.append(produto)
            self._lista_de_quantidades.append(quantidade)
        

    def _calcular_valor_total(self):
        total = 0.0
        for produto, quantidade in zip(self._lista_de_produtos, self._lista_de_quantidades):
            total += produto.preco * quantidade
        self._valor_total = total

    def __str__(self):
        header = f"--- Venda ID: {self._id_venda} | Status: {self._status} ---\n"
        cliente_info = f"Cliente: {self._cliente.nome}\n"
        func_info = f"Vendedor: {self._funcionario.nome}\n"
        itens_header = "Itens:\n"
        itens_list = ""
        if not self._lista_de_produtos:
            itens_list = "  Nenhum item na venda.\n"
        else:
            for produto, quantidade in zip(self._lista_de_produtos, self._lista_de_quantidades):
                subtotal = produto.preco * quantidade
                itens_list += f"  - {produto.nome} | {quantidade} un. x R$ {produto.preco:.2f} = R$ {subtotal:.2f}\n"
        
        footer = f"VALOR TOTAL: R$ {self.valor_total:.2f}\n" + "-"*50
        
        return header + cliente_info + func_info + itens_header + itens_list + footer