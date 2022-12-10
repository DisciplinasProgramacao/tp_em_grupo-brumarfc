# POO - Agência de turismo

## Nota: 14,8

## Comentários
	- busca por cliente e bilhetes: fazendo "for" em listas...
	(1) vocês já sabem de aed que "for" não é para busca
	(2) vimos o uso de coleções que resolvem isso 
	
## Correção

### Modelagem: 2/2

### Documentação e aderência ao modelo: 1,5/2
	- Arquivo de testes: dados insuficientes para testar fidelidade
	
### Requisitos Cliente: 7,5/10 
	- Bilhete com vários voos:	0,5/3  (bilhete fixo, não posso comprar o que quero)
	- Preço/pontuação/aceleração de bilhetes	4/4
	- Verificação de fidelidade	3/3
	
### Requisitos Empresa: 6,8/8
	- Dados de cliente	1,8/2 (sem informação de pontos)
	- Cliente com mais pontos	2/2
	- Voo cidade/data/100 reservas	1/2  (deu exceção em caso de 0 voos. E podia ser resolvido com mapas ou coleções)
	- Total arrecadado / filtro mês	2/2
	
### Apresentação e aderência ao SOLID 
	- Instance of em lugar de polimorfismo (bilhete) -> -2
	- string em lugar de enum (acelerador) -> -1
	
