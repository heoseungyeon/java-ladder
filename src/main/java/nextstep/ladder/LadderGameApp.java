package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LineGenerationStrategy;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.RandomLineGenerationStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.AskHeightOfLadderDto;
import nextstep.ladder.view.dto.AskParticipantNamesDto;
import nextstep.ladder.view.dto.LadderCreateResultDto;

public class LadderGameApp {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        AskParticipantNamesDto askParticipantNamesDto = inputView.askParticipantNames();
        Names names = askParticipantNamesDto.getNames();

        AskHeightOfLadderDto askHeightOfLadderDto = inputView.askHeightOfLadder();
        int heightOfLadder = askHeightOfLadderDto.getHeight();

        LineGenerationStrategy lineGenerationStrategy = new RandomLineGenerationStrategy();

        Ladder ladder = Ladder.of(lineGenerationStrategy, names.getNamesSize(), heightOfLadder);

        ResultView resultView = new ResultView();
        LadderCreateResultDto ladderCreateResultDto = LadderCreateResultDto.of(names, ladder);
        resultView.showLadderCreateResult(ladderCreateResultDto);
    }
}
