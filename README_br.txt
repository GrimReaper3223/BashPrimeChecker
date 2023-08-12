Esse é meu primeiro aplicativo "complexo" (com muitas linhas de código e muita lógica envolvida) que já fiz até hoje.

Esse app é dividido em 2 partes: Fase 1 de execução e Fase 2 de execução;

O código está altamente documentado, então esse arquivo será somente um resumo sobre as funcionalidades.

	[Esse projeto é somente uma demonstração pessoal sobre meu progresso na linguagem Java. O arquivo principal de execução é o "execute", e o arquivo de instrução é o "PrimeNumbersVerify" (dentro do 
	arquivo "manifest.txt" está especificado que o arquivo que contém a classe principal de execução é a "execute.class".]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Aqui inicia a primeira fase de execução do código. Aqui o usuário irá inserir um valor máximo para geração da tabela e um número para verificação, será também realizado o cálculo dos dados, atribuição dos 
valores as arrays, reprocessamento da array de números primos para uma nova array filtrando todos os zeros (espaços vazios) e, dependendo do tamanho dos dados, para nao prejudicar a experiência do usuário,
será perguntado ou nao se ele deseja mostrar todos os números primos gerados;

Fase 1:

	-Nessa fase, inicialmente haverá um método com um objeto instanciado da classe nativa 'Scanner' para recebimento de dados do usuário;
	-Há tratativas de erros dependendo dos dados fornecidos pelo usuário, como por exemplo: 
		
		*O número a ser verificado não deve ser maior que o número da tabela;
		*O número a ser verificado não deve ser menor que 2 (limite mínimo de geração da tabela);
		*O número da tabela não deve ser menor que 2 (limite mínimo de geração da tabela);
		
		Fora essas tratativas, o programa irá performar normalmente;
	
	-Nesta mesma fase, temos o método de cálculo (baseado no Crivo de Eratóstenes);
	-Neste método, inicialmente a tabela é gerada de acordo com o limite máximo imposto pelo usuário;
	
	-Então, é verificado se o usuário inseriu um valor máximo para a geração da tabela maior que 10 ou menor que 11 (Essa verificação é necessária para evitar um bug ao gerar a tabela. Sem esta
	verificação,
	qualquer valor que for colocado acima de 10 irá coincidir com um número primo resultado do cálculo, então a tabela será gerada. Na mão contrária, inserir numeros abaixo de 10 a tabela não será gerada
	e
	o número primo não será devidamente verificado, porque 2, 3, 5 e 7 foram usados como base de cálculo. Logo, os mesmos entrarão no cálculo do método de acordo com a fórmula (qualquer número dividido
	por 2, 3, 5 ou 7 que retornar 0 não será primo). Então esses números precisam ser adicionados manualmente na tabela, sem precisar alterar a lógica de cálculo). Então, com esse método isso é corrigido, 
	independente do número que o usuário inserir (e claro, que esteja de acordo com as outras condicionais)).
	
	-Após os cálculos e atribuições, o campo que receberá os valores primos estarão repletos de zeros desnecessários. Há um próximo método que limpará toda a array de números primos (removerá todos os 0s)
	e retornará uma nova array limmpa somente com os inteiros primos;
	-Após o reprocessamento da array original de números primos, temos o último método que mostrará ao usuário os números primos na nova tabela em formato de uma array de Strings;
	-Dependendo do tamanho dos resultados (mesmo após o reprocessamento dos dados), será gerado uma mensagem para o usuário mostrando a quantidade de números primos encontrados e se ele deseja que eles
	sejam mostrados na tela (isso é realizado para evitar poluição do prompt e para melhorar a experiência do usuário). Os números primos serão mostrados se a array de Strings for pequena ou de um tamanho
	aceitável;
		
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Aqui termina a primeira fase de execução do código. A segunda será relacionada a verificação do segundo número que o usuário inseriu e se o usuário deseja reiniciar o teste;

Fase 2:

	-A segunda fase se inicia com um método de verificação de número do usuário com base na array de números reprocessada para verificar se é um número primo ou não;
	-Se o número for primo, existe um campo declarado anteriormente que é usado para controle de fluxo do programa chamado de 'alsePrint'. Esse campo tem o valor booleano "false", e ele será "true" se o
	número for testado positivamente como primo. Caso contrário, o campo continuará com seu valor "false" e ele ativará a segunda condicional, indicando que o número que foi testado não foi encontrado
	na array de números primos, e, portanto, ele não é um número primo. Independente dos casos, será mostrada na tela do prompt uma mensagem para o usuário contendo o número que ele inseriu e se é ou não
	primo;
	
	-O último método dessa fase consiste em obter uma resposta do usuário (y/n) se ele deseja executar novamente o teste;
	-Se a resposta for 'y', o programa imprimirá uma mensagem no promp comunicando que um novo teste será executado, o campo "falsePrint" terá seu valor reiniciado para "false" (caso tenha testado 
	positivo, pois essa é a única variável que não se sobrescreve assim que o teste é reiniciado) e é chamado o primeiro método da classe (que novamente irá obter um valor oferecido pelo usuário e irá
	realizar todos os outros testes mencionados acima);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Para cada mensagem no prompt existem alguns sinais específicos que atribui para que o usuário possa identificar o que está sendo realizado. Abaixo deixarei um glossário a respeito disso:

	>>>	user input;
	###	error;
	$$$	many data;
	<<<	returning to execute the next function;
	+++	final result;
	
Haverá também um execútavel em .jar que irei compilar para que se possa realizar os testes necessários em sua máquina. Qualquer máquina que contiver uma JVM conseguirá, com sucesso, iniciar a compilação pelo
terminal/cmd;

