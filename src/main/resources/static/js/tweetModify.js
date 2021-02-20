function modify(tweet, creator, dp){
 alert("You are in a different function");
 var tweetModified = `                    <li>
                                  <article class="tweet-item">
                                      <img class="profile-image" src="` + dp +  `" alt="codetalks.tv"> <!--Your profile pictire should be there!!-->
                                      <header class="tweet-item-info u-flex">
                                          <a class="tweet-item-info-user" href="https://twitter.com/eladsc" target="_blank">
                                              <span class="common-title">`+ creator +`</span> <!-- Who created the text !!! Your name should be there in chrome somehow-->
                                          </a>
                                          <time datetime="">Jun 10</time>
                                          <button class="icon-button u-flex u-margin-start-auto" style="--icon-button-size:27px;"><span class="icon icon-arrow-down u-margin-auto"></span></button>
                                      </header>
                                      <div class="common-content">
                                          <p>`+ tweet +` <!-- Your text should be here !!! --->
                                          </p>
                                      </div>
                                      <ul class="message-options u-flex u-space-between">
                                          <li class="message-options-item">
                                              <label>
                                                  <button onclick="expandCommentSection(this)" class="icon-button"><span class="icon">💬</span></button>
                                                  <span class="text"></span>
                                              </label>
                                          </li>
                                          <li class="message-options-item">
                                              <label>
                                                  <button class="icon-button"><span class="icon">🔃</span></button>
                                                  <span class="text">0</span>
                                              </label>
                                          </li>
                                          <li class="message-options-item">
                                              <label>
                                                  <button class="icon-button"><span class="icon">❤</span></button>
                                                  <span class="text">0</span>
                                              </label>
                                          </li>
                                          <li class="message-options-item">
                                              <label>
                                                  <button class="icon-button"><span class="icon">📤</span></button>
                                                  <span class="text"></span>
                                              </label>
                                          </li>
                                      </ul>
                                  </article>
                                  </li>`;
                           console.log(tweetModified);
        return tweetModified;

}
