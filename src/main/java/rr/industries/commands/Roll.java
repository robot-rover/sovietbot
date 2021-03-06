package rr.industries.commands;

import reactor.core.publisher.Mono;
import rr.industries.exceptions.BotException;
import rr.industries.exceptions.IncorrectArgumentsException;
import rr.industries.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@CommandInfo(
        commandName = "roll",
        helpText = "Rolls a random number in a variety of ways",
        pmSafe = true
)
public class Roll implements Command {
    @SubCommand(name = "", Syntax = {
            @Syntax(helpText = "Rolls a number 1-100", args = {}),
            @Syntax(helpText = "Rolls a number 1-#", args = {@Argument(Validate.NUMBER)}),
            @Syntax(helpText = "Rolls the dice RP style. Rolls a number 1-Y, X times", args = {@Argument(Validate.DND)})
    })
    public Mono<Void> execute(CommContext cont) throws BotException {
        StringBuilder message = new StringBuilder();
        int roll;
        if (cont.getArgs().size() >= 2) {
            Matcher dnd = Pattern.compile("(\\d+)d(\\d+)").matcher(cont.getArgs().get(1));
            if (dnd.find()) {
                int reps = Integer.parseInt(dnd.group(1));
                int value = Integer.parseInt(dnd.group(2));
                if(value < 1) {
                    throw new IncorrectArgumentsException("Cannot roll to the number " + value);
                }
                List<Integer> rolls = new ArrayList<>();
                message.append("**Rolling: **" + cont.getArgs().get(1) + "\n");
                for (int i = 0; i < reps; i++) {
                    rolls.add(rn.nextInt(value) + 1);
                }
                message.append(rolls.stream().map(Object::toString).collect(Collectors.joining(", ")));
                message.append("\n**Total: **" + (Integer) rolls.stream().mapToInt(v -> v).sum());

            } else {
                roll = Integer.parseInt(cont.getArgs().get(1));
                if(roll < 1) {
                    throw new IncorrectArgumentsException("Cannot roll to the number " + roll);
                }
                message.append("Rolling 1 to " + Integer.toString(roll) + ": " + (rn.nextInt(roll) + 1));
            }
        } else {
            message.append("Rolling 1 to 100: " + (rn.nextInt(100) + 1));
        }
        return cont.getChannel().createMessage(message.toString()).then();
    }
}
