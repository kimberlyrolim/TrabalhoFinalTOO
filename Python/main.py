from produto import Produto
from cliente import Cliente
from funcionario import Funcionario
from venda import Venda
from datetime import datetime

def run_loja():
    p1 = Produto(id_produto=1, nome="Mouse", descricao="Bluetooth", preco=50.00, qtd_estoque=100)
    p2 = Produto(id_produto=2, nome="SSD", descricao="M2 256 GB", preco=200.00, qtd_estoque=100)
    p3 = Produto(id_produto=3, nome="Manutenção", descricao="Troca de HD para SSD", preco=100.00, servico=True)

    print("--- Estoque Atual ---")
    print(p1)
    print(p2)
    print(p3)

    cliente = Cliente(nome="Mariana", cpf="987.654.321-10", telefone="911223344", endereco="Avenida Presidente Vargas, 10", id_cliente=1)
    funcionario = Funcionario(nome="Kimberly", cpf="123.456.789-10", telefone="988776655", endereco="Avenida Brasil, 10", matricula="01", cargo="Vendedora", data_admissao=datetime(2022, 10, 10) )

    # 3. Iniciar uma nova venda
    venda1 = Venda(id_venda=101, cliente=cliente, funcionario=funcionario)
    venda2 = Venda(id_venda=102, cliente=cliente, funcionario=funcionario)

    # 4. Adicionar itens à venda
    print("\n--- Venda 1 ---")
    venda1.adicionar_item(p1, 2) # Adiciona 2 mouse
    venda1.adicionar_item(p2, 1) # Adiciona 1 ssd
    venda1.adicionar_item(p3, 1) # Adiciona 1 serviço
    print(venda1)
    
    print("\n--- Nota Fiscal 1 ---")
    venda1._status = "Pagamento Efetuado"
    print(venda1)

    print("\n--- Estoque Atualizado ---")
    print(p1)
    print(p2) 
    print(p3) 


     # 4. Adicionar itens à venda
    print("\n--- Venda 2 ---")
    venda2.adicionar_item(p1, 1) # Adiciona 2 mouse
    venda2.adicionar_item(p2, 2) # Adiciona 1 ssd
    venda2.adicionar_item(p3, 2) # Adiciona 1 serviço
    print(venda2)
    
    print("\n--- Nota Fiscal 2 ---")
    venda2._status = "Pagamento Efetuado"
    print(venda2)

    print("\n--- Estoque Final ---")
    print(p1)
    print(p2) 
    print(p3) 

    cliente.consultar_historico()

    funcionario.consultar_historico()


if __name__ == "__main__":
    run_loja()