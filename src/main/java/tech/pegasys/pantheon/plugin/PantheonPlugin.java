/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.pantheon.plugin;

/**
 * Base interface that Pantheon plugins should implement.
 *
 * <p>Plugins are discovered and loaded using {@link java.util.ServiceLoader} from jar files within
 * Pantheon's plugin directory.
 */
public interface PantheonPlugin {

  /**
   * Called when the plugin is first registered with Pantheon. Plugins are registered very early in
   * the Pantheon life-cycle and should use this callback to register any command line options
   * required via the {@link tech.pegasys.pantheon.plugin.services.PicoCLIOptions} service.
   *
   * <p>The plugin should not begin operation until the {@link #start()} method is called.
   *
   * @param context the context that provides access to Pantheon services.
   */
  void register(PantheonContext context);

  /**
   * Called once Pantheon has loaded configuration and is starting up. The plugin should begin
   * operation, including registering any event listener with Pantheon services and starting any
   * background threads the plugin requires.
   */
  void start();

  /**
   * Called when the plugin is being stopped. This method will be called as part of Pantheon
   * shutting down but may also be called at other times to disable the plugin.
   */
  void stop();
}
