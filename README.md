Ferramenta-NC
Ferramenta-NC é um sistema simples e automatizado para apoiar o processo de auditoria de qualidade em projetos. A aplicação permite criar e aplicar checklists de conformidade, registrar não conformidades (NC), monitorar seu tratamento e resolução, além de gerar comunicações formais.

--Funcionalidades: 

-Criação e gerenciamento de checklist de auditoria

-Cadastro de itens de verificação

-Aplicação de checklist com cálculo automático do % de aderência

-Registro de Não-Conformidade (NC)

-Registro detalhado com descrição, data, responsável e tipo da NC

-Relacionamento com os itens do checklist

--Acompanhamento de NC

Atualização do status de cada NC

Controle de prazos e resoluções

--Comunicação de NC

Geração de comunicados automáticos de NC

Identificação do nível da não conformidade e prazos para resposta

--Estrutura do Projeto
O projeto está estruturado em arquivos Java simples, organizados conforme a lógica de uso da ferramenta:

Arquivo	Descrição
MenuPrincipal.java:	Interface principal do sistema, ponto de entrada e navegação
CadastroItem.java:	Cadastro e listagem dos itens do checklist de auditoria
ItemChecklist.java:	Classe que representa um item do checklist
RegistroNC.java:	Cadastro e gerenciamento de registros de não conformidade
ComunicacaoNC.java:	Geração de comunicados de NC, incluindo níveis e prazos
PlanoDeProjeto.java:	Integração com os documentos e informações do projeto auditado

Tecnologias
Linguagem: Java

Interface: Console (CLI)

Persistência de dados: ainda não implementada (versão básica)


--Futuras Melhorias
Persistência em arquivos ou banco de dados

Melhorar Interface gráfica

Exportação de relatórios (PDF/CSV)

Integração com e-mail para envio automático de comunicações

Licença
Este projeto é de uso educacional e pode ser adaptado livremente.
