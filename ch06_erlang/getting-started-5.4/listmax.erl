-module(listmax).
-export([list_max/1]).

list_max([Head|Rest]) ->
    list_max(Rest, Head).

list_max([], Res) ->
    Res;
list_max([Head|Rest], Result_so_far) when Head > Result_so_far ->
    list_max(Rest, Head);
list_max([Head|Rest], Result_so_far) ->
    list_max(Rest, Result_so_far).

%% Example:
%% listmax:list_max([1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 9, 3, 2, 1]).
