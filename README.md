# GestaoHospitalar_JAVA
Alunos: Fernando Antonio e Michely Serras. <br>
## Diagrama de Classes
![diagrama](https://github.com/nandoant/GestaoHospitalar_JAVA/blob/main/DiagramaDeClasses.png?raw=true)
## Regras de Negocio
### Paciente
- Paciente só poderá ter uma consulta ativa <br>
- Mudanças de status exigem autenticação médica <br>
- Não é possível iniciar nova consulta se o paciente tiver uma ativa <br>
- Não é possivel deletar um paciente que esteja registrado em uma consulta<br>
### Medico 
- Não é possivel deletar um medico que já esteja registrado em uma consulta<br>
- Qualquer medico pode mudar o status do paciente <br>
