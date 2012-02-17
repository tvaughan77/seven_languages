-module(tut).
-export([double/1, fac/1, mult/2]).
-export([convert/2]).

%% Variables must start with a capital letter 
double(X) ->
    2 *  X.

fac(1) ->
    1;
fac(N) ->
    N * fac(N - 1).

mult(X, Y) ->
    X * Y.


%% Atoms are another data type in Erlang. Atoms start with a small letter
convert(M, inch) ->
    M / 2.54;
convert(N, centimeter) ->
    N * 2.54.
