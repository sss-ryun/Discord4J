/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.rest.service;

import discord4j.common.util.Snowflake;
import discord4j.discordjson.json.WebhookModifyRequest;
import discord4j.rest.DiscordTest;
import discord4j.rest.RestTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebhookServiceTest {

    private static final long permanentChannel = Snowflake.asLong(System.getenv("permanentChannel"));
    private static final long guild = Snowflake.asLong(System.getenv("guild"));
    private static final long permanentWebhook = Snowflake.asLong(System.getenv("permanentWebhook"));

    private WebhookService webhookService;

    @BeforeAll
    public void setup() {
        webhookService = new WebhookService(RestTests.defaultRouter());
    }

    @DiscordTest
    public void testCreateWebhook() {
        // TODO
    }

    @DiscordTest
    public void testGetChannelWebhooks() {
        webhookService.getChannelWebhooks(permanentChannel).then().block();
    }

    @DiscordTest
    public void testGetGuildWebhooks() {
        webhookService.getGuildWebhooks(guild).then().block();
    }

    @DiscordTest
    public void testGetWebhook() {
        webhookService.getWebhook(permanentWebhook).block();
    }

    @DiscordTest
    public void testModifyWebhook() {
        WebhookModifyRequest req = WebhookModifyRequest.builder()
            .name("Permanent Webhook")
            .build();
        webhookService.modifyWebhook(permanentWebhook, req, null).block();
    }

    @DiscordTest
    public void testDeleteWebhook() {
        // TODO
    }
}
