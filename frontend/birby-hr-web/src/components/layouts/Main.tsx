import MainProps from './props/MainProps';
function Main({ children }: MainProps) {
    return (
        <>
            <main>
                <div className="mb-10">
                    {children}
                </div>
            </main>
        </>
    )
}
export default Main;