
from datetime import datetime
from typing import Optional

from pessoa import Pessoa 

class Funcionario(Pessoa):
    
    def __init__(self, nome: str, cpf: str, telefone: str, endereco: str, matricula: str, cargo: str, data_admissao: Optional[datetime] = None):
     
        super().__init__(nome, cpf, telefone, endereco)
        self._matricula = matricula
        self.cargo = cargo
        
        if data_admissao is None:
            self._data_admissao = datetime.now()
        else:
            self._data_admissao = data_admissao
        
        self.historico_vendas = []

    @property
    def matricula(self) -> str:
        return self._matricula

    @property
    def data_admissao(self) -> datetime:
        return self._data_admissao

    def adicionar_venda_ao_historico(self, venda):
        """Este método é chamado pela classe Venda para registrar uma compra."""
        self.historico_vendas.append(venda)

    def consultar_historico(self):
        """Exibe os dados do funcionário e um resumo de seu histórico de vendas."""
        print(f"\n--- Histórico de Vendas do Funcionário: {self.nome} ---")
        
        print(f"Cargo: {self.cargo}")
        print(f"Data de Admissão: {self.data_admissao.strftime('%d/%m/%Y')}")
        
        if not self.historico_vendas:
            print("\nNenhuma venda registrada para este funcionário.")
            return

        print("\n-- Vendas Realizadas --")
        total_vendido = 0
        for venda in self.historico_vendas:
            total_vendido += venda.valor_total
            print(f"  - Venda ID: {venda._id_venda} | Cliente: {venda._cliente.nome} | Valor: R$ {venda.valor_total:.2f}")
        
        print(f"\nValor Total Vendido pelo funcionário: R$ {total_vendido:.2f}")
        print("-" * 50)

    def __str__(self):
        """Representação em string do objeto Funcionário."""
        return f"Funcionário: {self.nome} | Matrícula: {self.matricula} | Cargo: {self.cargo}"