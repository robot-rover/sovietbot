/*
Add This Bot to Your Server:
https://discordapp.com/oauth2/authorize?&client_id=184445488093724672&scope=bot&permissions=19950624
 */

 /* Permissions List
MANAGE_GUILD	0x00000020  Allows management and editing of the guild
READ_MESSAGES	0x00000400  Allows reading messages in a channel. The channel will not appear for users without this permission
SEND_MESSAGES	0x00000800  Allows for sending messages in a channel
EMBED_LINKS     0x00004000  Links sent by this user will be auto-embedded
CONNECT 	    0x00100000  Allows for joining of a voice channel
SPEAK           0x00200000  Allows for speaking in a voice channel
MOVE_MEMBERS	0x01000000  Allows for moving of members between voice channels
MANAGE_MESSAGES 0x00002000  Allows for deletion of other users messages

Total:          19950624
 */
package rr.industries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rr.industries.exceptions.BotException;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.modules.IModule;
import sx.blah.discord.util.DiscordException;

public class Launcher {
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);
    static SovietBot bot;

    public static void main(String[] args) throws BotException {
        try {
            IDiscordClient client = new ClientBuilder().withToken(args[0]).setMaxReconnectAttempts(6).build();
                try {
                    login(client);
                } catch (DiscordException ex) {
                    ex.printStackTrace();
                    return;
                }
        } catch (DiscordException ex) {
            LOG.error("The Bot could not start", ex);
        }
    }

    public static void login(IDiscordClient client) throws DiscordException {
        LOG.info("\n------------------------------------------------------------------------\n### SovietBot ###\n------------------------------------------------------------------------");
        bot = new SovietBot();
        client.getDispatcher().registerListener(bot);
        bot.enable(client);
        client.login();

    }
}
