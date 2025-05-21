**Ferramenta-NC**
Ferramenta-NC é uma aplicação simples e modular desenvolvida para automatizar auditorias de qualidade em projetos.
Ela oferece recursos para aplicação de checklists, registro de não conformidades (NCs), acompanhamento de status e comunicações formais, tudo em um único lugar.

Ideal para equipes que buscam agilidade, rastreabilidade e controle sobre o processo de auditoria.

**Principais Recursos**
1. Checklist de Auditoria
Criação e edição de checklists personalizados

Cadastro de itens de verificação com critérios definidos

Cálculo automático do percentual de aderência

2. Registro de Não Conformidade (NC)
Registro detalhado com:

Descrição da não conformidade

Responsável

Tipo e data

Relacionamento direto com os itens não atendidos do checklist

3. Acompanhamento de NCs
Atualização do status conforme o andamento das tratativas

Controle de prazos e resoluções pendentes

4. Comunicação de NCs
Geração automatizada de comunicados formais

Classificação por nível da NC

Definição de prazos para resposta e correção

**Estrutura do Projeto**
bash
Copiar
Editar
Ferramenta-NC/
├── CadastroItem.java         # Cadastro de itens do checklist
├── ItemChecklist.java        # Representação dos itens do checklist
├── RegistroNC.java           # Registro e gestão das não conformidades
├── ComunicacaoNC.java        # Geração de comunicados de NC
├── PlanoDeProjeto.java       # Integração com dados do plano de projeto
└── MenuPrincipal.java        # Interface principal do sistema


**Melhorias Futuras**
Persistência de dados com arquivos ou banco de dados

Melhorar Interface gráfica

Exportação de relatórios (PDF/CSV)

Envio automático de e-mails com comunicados de NC

Controle de usuários e permissões



**Licença**
Este projeto é de uso educacional e pode ser adaptado livremente.
