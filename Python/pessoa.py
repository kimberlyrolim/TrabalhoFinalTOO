from abc import ABC, abstractmethod

class Pessoa(ABC):
    """Classe base abstrata para Cliente e Funcionario."""
    def __init__(self, nome: str, cpf: str, telefone: str, endereco: str):
        self._nome = nome
        self._cpf = cpf  
        self._telefone = telefone
        self._endereco = endereco

    @property
    def nome(self) -> str:
        return self._nome

    @nome.setter
    def nome(self, valor: str):
        self._nome = valor

    @property
    def cpf(self) -> str:
        return self._cpf


    @property
    def telefone(self) -> str:
        return self._telefone

    @telefone.setter
    def telefone(self, valor: str):
        self._telefone = valor

    @property
    def endereco(self) -> str:
        return self._endereco

    @endereco.setter
    def endereco(self, valor: str):
        self._endereco = valor

    @abstractmethod
    def consultar_historico(self):
        """Método abstrato que subclasses devem implementar."""
        pass

    def __str__(self):
        return f"Nome: {self.nome}, CPF: {self.cpf}"