# Engenharia de Software

**Qualidade de Software  - 4º semestre - PUCPR**

Atividades práticas sobre qualidade de software Java, desenvolvidas durante o curso de Engenharia de Software.

---

#  Ferramenta-NC

**Ferramenta-NC** é uma aplicação simples e modular desenvolvida para automatizar auditorias de qualidade em projetos. Com ela, é possível aplicar checklists personalizados, registrar não conformidades (NCs), acompanhar o status das tratativas e gerar comunicações formais — tudo em um único lugar.

> Ideal para equipes que buscam **agilidade**, **rastreabilidade** e **controle** no processo de auditoria.

---

##  Funcionalidades

-  **Checklist de Auditoria**
  - Criação e edição de checklists personalizados
  - Cadastro de itens com critérios definidos
  - Cálculo automático do percentual de aderência

-  **Registro de Não Conformidades (NC)**
  - Registro detalhado com: descrição, responsável, tipo e data
  - Relacionamento direto com os itens do checklist

- **Acompanhamento de NCs**
  - Atualização de status conforme andamento das tratativas
  - Controle de prazos e pendências

-  **Comunicação de NCs**
  - Geração automatizada de comunicados formais
  - Classificação por nível da NC
  - Definição de prazos para resposta e correção

---

##  Tecnologias Utilizadas

> Projeto desenvolvido em **Java puro**.

---

## Estrutura do Projeto

```
Ferramenta-NC/
├── CadastroItem.java         # Cadastro de itens do checklist
├── ItemChecklist.java        # Representação dos itens de verificação
├── RegistroNC.java           # Registro e gestão das NCs
├── ComunicacaoNC.java        # Geração de comunicados de NC
├── PlanoDeProjeto.java       # Integração com dados do plano de projeto
└── MenuPrincipal.java        # Interface principal do sistema
```

---

##  Melhorias Futuras

- Persistência de dados (arquivos ou banco de dados)
- Exportação de relatórios (PDF/CSV)
- Envio automático de e-mails com comunicados de NC
- Controle de usuários e permissões
- Interface gráfica aprimorada

---


## 🤝 Contribuições

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch com sua feature: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'Minha nova feature'`
4. Push para a branch: `git push origin minha-feature`
5. Abra um Pull Request

---

## 📄 Licença

Este projeto é de uso **educacional** e pode ser **adaptado livremente**.
