# Calculadora de Consumo de Combustível
## Descrição
O **FuelSaver** é um aplicativo Android desenvolvido em Java que permite calcular
o consumo de combustível e o custo total de uma viagem com base nos dados
informados pelo usuário.
Este projeto foi desenvolvido como exercício prático para a disciplina de
Desenvolvimento Mobile, utilizando Android Studio.
---
## Funcionalidades
- Cadastro dos dados do veículo e da viagem
- Cálculo da quantidade de combustível necessária
- Cálculo do custo total da viagem
- Exibição clara dos resultados
- Validação de campos obrigatórios
---
## Fórmulas Utilizadas
- **Combustível necessário (L)** 
  Distância (km) ÷ Consumo médio (km/L)
- **Custo da viagem (R$)** 
  Combustível necessário (L) × Preço por litro (R$)

---
## Interface do Aplicativo
Campos disponíveis:
- Nome do veículo
- Placa do veículo
- Distância (km)
- Consumo médio (km/L)
- Preço do combustível (R$/L)
Resultados exibidos:
- Combustível necessário (litros)
- Custo da viagem (reais)
---
## Tecnologias Utilizadas
- **Linguagem:** Java
- **Layout:** XML
- **IDE:** Android Studio
- **Build:** Gradle (Groovy)
- **SDK Mínimo:** API 21 (Android 5.0)
---
## Requisitos
- Preenchimento obrigatório de todos os campos
- Valores numéricos maiores que zero
- Formatação monetária em R$
- Interface simples e responsiva
---
## Como Executar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/RafaelAlegranzziKlein/Calculadora-de-combustivel.git
