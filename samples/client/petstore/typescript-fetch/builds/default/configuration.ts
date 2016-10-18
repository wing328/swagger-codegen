export interface Dictionary<T> { [index: string]: T; }

export class Configuration {
    apiKey: Dictionary<string> = {};
    username: string;
    password: string;
    accessToken: string;
}