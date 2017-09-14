package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente de forma a fugir na direção contrária ao alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Chegar extends AlgoritmoMovimentacao {

    private static final char NOME = 'a';

    public Chegar(float maxVelocidade) {
        super(NOME);
        super.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 aux = new Vector3(alvo.getObjetivo());
        output.velocidade = aux.sub(agente.posicao);                
        output.velocidade.nor();
        output.velocidade = output.velocidade.scl(maxVelocidade);
        if(agente.posicao.dst2(alvo.getObjetivo())>raio*raio){           
            agente.olharNaDirecaoDaVelocidade(output.velocidade);            
        }
        output.rotacao = 0;
        return output;
        
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.A;
    }

}