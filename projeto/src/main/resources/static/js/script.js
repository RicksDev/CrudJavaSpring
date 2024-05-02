function showAndHideLogo() {
  // Selecione o elemento da logo
  const logoContainer = document.querySelector(".logo-container");
 
  // Mostra a logo com efeito de fade-in
  logoContainer.classList.add("show");
 
  // Define um temporizador para esconder a logo após 3 segundos
  setTimeout(() => {
    // Adiciona a classe hide para esconder a logo com efeito de fade-out
    logoContainer.classList.add("hide");
  }, 1000); // 3000 milissegundos = 3 segundos
}
 
// Chame a função para mostrar e esconder a logo quando a página é carregada
document.addEventListener("DOMContentLoaded", showAndHideLogo);
 
// Lógica escolha de carros
 
// Selecione o elemento select de veículo
// Selecione os elementos select de veículo e cor
const veiculoSelect = document.getElementById("veiculo");
const corSelect = document.getElementById("cor");
 
// Adicione event listeners para detectar mudanças na seleção
veiculoSelect.addEventListener("change", atualizarValor);
corSelect.addEventListener("change", atualizarValor);
 
// Função para atualizar o valor com base nas seleções de veículo e cor
function atualizarValor() {
  // Obtenha o valor selecionado para o veículo e a cor
  const veiculoSelecionado = veiculoSelect.value;
  const corSelecionada = corSelect.value;
 
  // Defina o valor base para o veículo selecionado
  let valor = 0;
 
  switch (veiculoSelecionado) {
    case "Rs6":
      valor = 1175000; // Defina o valor base para Audi RS6
      break;
    case "Porsche":
      valor = 1920000; // Defina o valor base para Porsche 911 GT3
      break;
    case "Audi":
      valor = 1160000; // Defina o valor base para Audi R8
      break;
    case "Toyota":
      valor = 1400000; // Defina o valor base para Supra Mk5
      break;
    case "Nissan":
      valor = 400000; // Defina o valor base para Skyline R34
      break;
    default:
      valor = 0; // Se nenhum veículo for selecionado, defina o valor como 0
      break;
  }
 
  // Acrescente um valor adicional com base na cor selecionada
  switch (corSelecionada) {
    case "Branco":
      valor += 100000; // Adicione um valor extra para a cor branca
      break;
    case "Preto":
      valor += 100000; // Adicione um valor extra para a cor preta
      break;
    case "Nardo":
      valor += 250000; // Adicione um valor extra para a cor nardo
      break;
    case "Prata":
      valor += 80000; // Adicione um valor extra para a cor prata
      break;
    case "Vermelho":
      valor += 150000; // Adicione um valor extra para a cor vermelha
      break;
    case "Amarelo":
      valor += 70000; // Adicione um valor extra para a cor amarela
      break;
    default:
      break;
  }
 
  // Atualize o valor exibido no campo correspondente
  const valorInput = document.querySelector('input[type="text"]');
  valorInput.value = valor.toLocaleString("pt-BR", {
    style: "currency",
    currency: "BRL",
  });
    valorInput.textContent = valor.toLocaleString("pt-BR", {
    style: "currency",
    currency: "BRL",
  });
}

document.addEventListener('DOMContentLoaded', function() {
    var form = document.getElementById('projetoForm');

    form.addEventListener('submit', (event) => {
        var veiculo = document.getElementById('veiculo').value;
        var cor = document.getElementById('cor').value;
        var preco = document.getElementById('preco').value;
        var metPag = document.getElementById('metPag').value;

        if (veiculo === 'null' || cor === 'null' || preco === '' || metPag === 'null') {
            alert('Por favor, preencha todos os campos obrigatórios.');
            event.preventDefault(); // Impede o envio do formulário se houver campos não preenchidos
        }
    });
});